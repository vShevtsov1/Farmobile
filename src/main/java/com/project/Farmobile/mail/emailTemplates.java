package com.project.Farmobile.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class emailTemplates {
    public String activationTemplate(String link){
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Map<String, Object> map = new HashMap<>();
            map.put("linkToActivation", link);
            Template template = cfg.getTemplate("ActivationEmail.ftl");
            Writer console = new StringWriter();
            template.process(map, console);
            String data = console.toString();
            console.flush();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getTamplateResetPassword(String link){
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Map<String, Object> map = new HashMap<>();
            map.put("linkToReset", link);
            Template template = cfg.getTemplate("resetPassword.ftl");
            Writer console = new StringWriter();// now it works fine
            template.process(map, console);
            String data = console.toString();
            console.flush();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "";
    }
}
