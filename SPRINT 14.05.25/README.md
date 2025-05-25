# 🛠️ Sprint 3 – Persistent Data & Database Integration

In Sprint 3, we transitioned from in-memory data management to a persistent PostgreSQL database using Docker. We restructured the project to follow a strict layered architecture based on the closed-layer model, separating Controllers, Services (Business Logic), and a dedicated Data Access Layer (DAL). All entities are now stored in the database using JPA entities, with full compliance to the specifications.

Key updates:

    PostgreSQL integration via Docker Compose with Spring Data JPA

    Business logic services now include transaction support and input validation

    DAL layer abstracts all database operations using repository interfaces

    Validation improvements: email format, non-null fields, valid roles (ADMIN, OPERATOR, END_USER)

    Immutable fields protected in PUT operations (e.g., systemId, creation timestamp, creators)

    Implemented object-to-object relationships and new REST endpoints for managing links

    Error handling with proper HTTP status codes (400, 404, 403, 401)

    Ready for future additions: security layer, automation logic, and real-time data visualization

This sprint marked a critical infrastructure milestone, ensuring persistent storage, transactional consistency, and a scalable base for upcoming automation and authentication features.
