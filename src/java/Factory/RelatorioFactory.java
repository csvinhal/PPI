/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Crouch
 */
public class RelatorioFactory {
        public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/ppi2", "root", "connect");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conexao;
    }
    
     public static void geraRelatorioGuia(int idGuia) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            HttpServletResponse response = (HttpServletResponse) context
                    .getExternalContext().getResponse();
            InputStream reportStream = context.getExternalContext().getResourceAsStream("/relatorio/guia.jasper");
            response.setContentType("application/pdf");
            ServletOutputStream servletOutputStream = response.getOutputStream();
            Map<String, Object> map = new HashMap<String, Object>();
		map.put("idGuia", idGuia);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, map, getConexao());
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            context.responseComplete();
        }
     }
     
     public static void geraRelatorioPreliminar(int idLaudo) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            HttpServletResponse response = (HttpServletResponse) context
                    .getExternalContext().getResponse();
            InputStream reportStream = context.getExternalContext().getResourceAsStream("/relatorio/toxicologico_preliminar.jasper");
            response.setContentType("application/pdf");
            ServletOutputStream servletOutputStream = response.getOutputStream();
            Map<String, Object> map = new HashMap<String, Object>();
		map.put("idLaudo", idLaudo);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, map, getConexao());
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            context.responseComplete();
        }
     }

}
