package com.accp.action;

import com.accp.util.FileUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;

public class Loginaction extends ActionSupport {
    private String name;
    private String pwd;
    private File upImg;
    private String upImgFileName;

    public String login(){
        System.out.println("desrdwserfwefsdf");
        if ("admin".equals(name)&&"111111".equals(pwd)){
            // 把name保存在session中
            ServletActionContext.getRequest().getSession().setAttribute("userName",name);
            String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("\\upload");
            FileUtil.writeFile(upImg,path,upImgFileName);
            return "webIndex";
        }else {
            return "Login";
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public File getUpImg() {
        return upImg;
    }

    public void setUpImg(File upImg) {
        this.upImg = upImg;
    }

    public String getUpImgFileName() {
        return upImgFileName;
    }

    public void setUpImgFileName(String upImgFileName) {
        this.upImgFileName = upImgFileName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
