package com.s19835.taskschedulerservice.model;

import com.s19835.shared.model.Job;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("SCHEDULED")
public class ScheduledJob extends Job {

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.PENDING;

    private LocalDateTime scheduledTime;
    private int retryCount = 0;

    public enum JobStatus {
        PENDING,
        PROCESSING,
        COMPLETED,
        FAILED,
        RETRY
    }

    // Additional Getters & Setters


    public JobStatus getStatus() {
        return status;
    }
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }
    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getRetryCount() {
        return retryCount;
    }
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
