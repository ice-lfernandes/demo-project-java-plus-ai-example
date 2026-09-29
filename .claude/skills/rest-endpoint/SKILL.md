---
name: rest-endpoint
description: How to create a REST endpoint in this project, in eight steps. Use when asked to add, create, or expose a new REST endpoint or API route in this Spring Boot app.
---

# Creating a REST endpoint here

1. Decide the resource and the HTTP method — one verb per endpoint, no
   verbs in the URL (`/api/greetings/{name}`, not `/api/getGreeting`).
2. Add a `@RestController` class in `src/main/java/com/javaplusai/demo/`,
   named after the resource (`GreetingController`, not `GreetingApi` or
   `GreetingService`).
3. Map the method with `@GetMapping`/`@PostMapping`/etc., not the generic
   `@RequestMapping`.
4. Model the response as a `record`, nested in the controller unless it's
   reused elsewhere.
5. No persistence. This project has no database — if the endpoint needs
   state, it's out of scope here.
6. Constructor injection only for any collaborator, per `CLAUDE.md`. Never
   field injection.
7. Add a `@WebMvcTest` for the controller with `MockMvc`, asserting status
   and body via `jsonPath`.
8. Run the project's tests before considering the endpoint done — see the
   `Stop` hook in `.claude/settings.json`, which does this automatically.
