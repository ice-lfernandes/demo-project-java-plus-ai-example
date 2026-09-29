# claude-code-ecosystem-demo

Minimal Spring Boot 4 / JDK 21 REST app, built to record the real-file
terminal inserts for **playlist 2, episode 1** —
`content-plan/scripts/02-01-claude-code-ecosystem-mapped-script.md`. No
persistence, no database: two endpoints, just enough app for the terminal to
show something real behind `CLAUDE.md`, the skill, and the hook.

## Endpoints

- `GET /api/status` → `{"status":"UP","service":"claude-code-ecosystem-demo"}`
- `GET /api/greetings/{name}` → `{"message":"Hello, {name}!"}`

## Run

```
./mvnw spring-boot:run
```

## Test

```
./mvnw test
```

## The three primitives from the script

This project carries the three examples used in the script's closing scene
(Cena 10) as real files, so they can be shown on screen instead of just
talked about:

- **Rule** — `CLAUDE.md`: always-applies stack and convention info.
- **Skill** — `.claude/skills/rest-endpoint/SKILL.md`: the eight-step
  procedure for adding an endpoint here.
- **Hook** — `.claude/settings.json` + `.claude/hooks/run-tests.sh`: a
  `Stop` hook that runs `./mvnw test` before the agent is allowed to finish,
  and exits 2 with the failure output on `stderr` if a test breaks.
