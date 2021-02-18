package anandh.department.types;

public class GetDepartmentResponse {
    private String name;
    private String process;
    private String location;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetDepartmentResponse{" +
                "name='" + name + '\'' +
                ", process='" + process + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }
}
