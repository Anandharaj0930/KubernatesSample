package anandh.employee.types;

import java.io.Serializable;

public class Department implements Serializable {
    private String name;
    private String process;
    private String location;

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

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", process='" + process + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
