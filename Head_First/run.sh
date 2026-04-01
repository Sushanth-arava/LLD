#!/bin/bash

PATTERN=$1
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
HEAD_FIRST="$ROOT/Head_First"

if [ -z "$PATTERN" ]; then
  echo "Usage: ./run.sh <PatternName>"
  echo ""
  echo "Available patterns:"
  for category in "$HEAD_FIRST"/*/; do
    cat_name=$(basename "$category")
    if [[ "$cat_name" == *_Patterns ]]; then
      echo "  [$cat_name]"
      for pattern in "$category"*/; do
        [ -d "$pattern" ] && echo "    - $(basename "$pattern")"
      done
    fi
  done
  exit 1
fi

# Find the pattern directory across all category folders
PATTERN_DIR=""
for category in "$HEAD_FIRST"/*/; do
  candidate="$category$PATTERN"
  if [ -d "$candidate" ]; then
    PATTERN_DIR="$candidate"
    CATEGORY=$(basename "$category")
    break
  fi
done

if [ -z "$PATTERN_DIR" ]; then
  echo "Error: Pattern '$PATTERN' not found in any category."
  exit 1
fi

# Derive relative path from ROOT for javac source-path style compilation
REL_PATH="${PATTERN_DIR#$ROOT/}"
OUT="$PATTERN_DIR/out"

cd "$ROOT"

if [ ! -f "$REL_PATH/Main.java" ]; then
  echo "Error: $REL_PATH/Main.java not found"
  exit 1
fi

mkdir -p "$OUT"

# Collect all java files under the pattern directory
JAVA_FILES=$(find "$REL_PATH" -name "*.java")

# Build package prefix from rel path (e.g. Head_First.Creational_Patterns.Factory)
PACKAGE=$(echo "$REL_PATH" | tr '/' '.')

echo "Running [$CATEGORY] -> $PATTERN"
javac -d "$OUT" $JAVA_FILES && java -cp "$OUT" "$PACKAGE.Main"
