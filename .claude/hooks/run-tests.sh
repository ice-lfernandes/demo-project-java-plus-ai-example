#!/usr/bin/env bash
# Stop hook: runs the project's tests before the agent is allowed to finish.
# Exit 0 lets the session stop. Exit 2 blocks it and hands this script's
# stderr back to the model as a correction — see CLAUDE.md and playlist 2,
# episode 1 (Cena 7 / Cena 10) for why this is a hook and not a rule.

set -euo pipefail

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$PROJECT_DIR"

SRC_DIR="src/main/java"
HASH_FILE=".claude/hooks/.src-main-java.sha256"

if [ ! -d "$SRC_DIR" ]; then
    exit 0
fi

CURRENT_HASH="$(find "$SRC_DIR" -type f -name '*.java' -exec sha256sum {} \; | sort | sha256sum | awk '{print $1}')"
PREVIOUS_HASH="$(cat "$HASH_FILE" 2>/dev/null || echo "")"

if [ "$CURRENT_HASH" = "$PREVIOUS_HASH" ]; then
    exit 0
fi

if ! ./mvnw -q test 2>test-output.log; then
    echo "Tests failed after a change under /src. Fix the failures below before finishing:" >&2
    cat test-output.log >&2
    rm -f test-output.log
    exit 2
fi

echo "$CURRENT_HASH" > "$HASH_FILE"
rm -f test-output.log
exit 0
