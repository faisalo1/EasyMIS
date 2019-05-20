package easymis.models.repository;

import java.sql.Date;

/**
 *
 * @author RashidKP
 */
public class QueryParams {
    private String paramName;
    private String paramValue;
    private Date paramDateValue;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Date getParamDateValue() {
        return paramDateValue;
    }

    public void setParamDateValue(Date paramDateValue) {
        this.paramDateValue = paramDateValue;
    }

    
    
}
