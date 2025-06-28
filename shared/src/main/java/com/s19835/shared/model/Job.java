package com.s19835.shared.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "job_type")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // pdf email etc

    @Column(columnDefinition = "TEXT")
    private String payload; // JSON def

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt =  LocalDateTime.now();

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(nullable = false)
    private int priority = 5; // 1-10 scale

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, PROCESSING, COMPLETED, FAILED

    @Column(name = "retry_count")
    private int retryCount = 0;

    // Constructors
    public Job() {}

    public Job(String type, String payload, LocalDateTime deadline, int priority) {
        this.type = type;
        this.payload = payload;
        this.deadline = deadline;
        this.priority = priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setPriority(int priority) {
        if (priority < 0 || priority > 10) {
            throw new IllegalArgumentException("Priority must be between 0 and 10");
        }
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", type=" + type + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", status=" + status + '\'' +
                ", retryCount=" + retryCount +
                "}";
    }
}
