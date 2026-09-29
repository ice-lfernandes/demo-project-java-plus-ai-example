# CLAUDE.md

This project is used to record the real-file terminal inserts for playlist 2,
episode 1 ("The Claude Code Ecosystem, Mapped in 10 Minutes"). It exists to
demonstrate the three primitives applied in the closing scene of that script —
this file is the **rule** example.

## Stack

This project uses Java 21 and Spring Boot 4. Always target that version —
don't downgrade the parent POM or the `java.version` property to make a
dependency fit.

## Conventions

- REST endpoints only, no persistence. Don't add a database, a repository
  layer, or an ORM to this project — that's out of scope for the demo.
- Constructor injection only, never field injection.
