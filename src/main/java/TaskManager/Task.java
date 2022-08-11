package TaskManager;

import Enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
    private String taskTitle;
    private String taskContent;
    private LocalDate creationDate;
    private LocalTime creationTime;
    private Status status;

    public Task() {
    }

    public Task(String taskTitle, String taskContent, LocalDate creationDate, LocalTime creationTime, Status status) {
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return  "TaskTitle: "+taskTitle + ", "+"TaskContent: "+taskContent+", "+"CreationDate: "+creationDate
                +", "+"CreationTime:"+creationTime+", "+"Status: "+status;
    }


}
