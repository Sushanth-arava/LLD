#!/bin/bash

PATTERN=$1

if [ -z "$PATTERN" ]; then
  echo "Usage: ./run.sh <PatternName>"
  echo ""
  echo "Available patterns:"
  for dir in "$(dirname "$0")/*/"; do
    echo "  - $(basename "$dir")"
  done
  exit 1
fi

ROOT="$(dirname "$0")/.."
SRC="Head_First/$PATTERN/Main.java"
OUT="Head_First/$PATTERN/out"

cd "$ROOT"

if [ ! -f "$SRC" ]; then
  echo "Error: $SRC not found"
  exit 1
fi

mkdir -p "$OUT"
javac -d "$OUT" Head_First/$PATTERN/*.java && java -cp "$OUT" "Head_First.$PATTERN.Main"
