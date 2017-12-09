package org.phoenix.model;

import javax.persistence.*;

/**
 * Created by Kemi on 2017/12/3.
 * Description:
 */
@Entity
@Table(name = "t_web_case_ext")
public class CaseExtBean {
    private int id;
    private int projectId;
    private int webCaseId;
    private String url;
    private String httpMethod;
    private String header;
    private String contenType;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getWebCaseId() {
        return webCaseId;
    }

    public void setWebCaseId(int webCaseId) {
        this.webCaseId = webCaseId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContenType() {
        return contenType;
    }

    public void setContenType(String contenType) {
        this.contenType = contenType;
    }
}
