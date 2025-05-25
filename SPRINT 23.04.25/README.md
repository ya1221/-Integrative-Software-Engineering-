# 🌀 Sprint 2 – Core System Foundation

In this sprint, we built the initial backend structure of our smart indoor air quality monitoring system using Spring Boot and RESTful APIs. All data is managed in-memory using Java Collections, aligned with the project's early-stage architecture.
We implemented full CRUD support for Users, Objects (such as sensors), and Commands, using modular separation between controllers, services, and entities.
Data boundaries strictly follow the given specification to ensure seamless JSON serialization and client-server integration.

System logic is intentionally minimal at this phase — focusing on storing, retrieving, updating, and deleting resources — with server-controlled fields like systemId, timestamps, and IDs automatically generated and protected.
Additionally, we established Admin APIs for system reset and laid the groundwork for future features like sensor integration, real-time alerts, and UI interaction.

This sprint sets the foundation for future development phases, prioritizing clean architecture, maintainability, and flexibility
