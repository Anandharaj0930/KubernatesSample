package anandh.employee.core;

import anandh.employee.types.core.IBuildCode;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BuildEmployeeCode implements IBuildCode {
    private static final String ord = "EMP";

    @Override
    public String buildCode() {
        StringBuilder stringBuilder = new StringBuilder(ord);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyymmssSSS");
        String dateValue = format.format(date);
        stringBuilder.append(dateValue);
        return stringBuilder.toString();
    }
}
