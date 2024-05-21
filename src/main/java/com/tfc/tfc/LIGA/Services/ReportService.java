package com.tfc.tfc.LIGA.Services;

import com.tfc.tfc.LIGA.Model.Jugador;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public byte[] exportToPdf(List<Jugador> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list));
    }


    private JasperPrint getReport(List<Jugador> list) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ds", new JRBeanCollectionDataSource(list));
        JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:ReporteJugadores.jrxml").getAbsolutePath()
        ), params, new JREmptyDataSource());
        return report;

    }

}
