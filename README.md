# JobQueue Optimizer

A smart, extensible job scheduling system built with Spring Boot microservices. This project simulates task dispatching, prioritization, and worker load balancing in a modular architecture.

## Modules

- `gateway-service`: Routes requests to internal services
- `task-scheduler`: Accepts and prioritizes incoming job submissions
- `worker-manager`: Simulates workers and handles job execution
- `shared`: Common DTOs and enums across services

## Version Roadmap

- **V0**: Multi-module project setup with test endpoints
- **V1**: In-memory job queue with priority logic
- **V2**: Worker simulation and job execution
- **V3**: Metrics and error handling
- **V4**: Gateway routing, config, Docker support
- **V5**: Benchmark mode with report output

## Getting Started

To run:

```bash
mvn clean install
cd task-scheduler
mvn spring-boot:run
