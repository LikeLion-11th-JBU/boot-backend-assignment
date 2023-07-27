package dev.tmddlf.consumer.model;

public class JobMessage {
    private String jobId;

    public JobMessage() {
    }

    public JobMessage(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "JobRequest{" +
                "jobId='" + jobId + '\'' +
                '}';
    }
}
