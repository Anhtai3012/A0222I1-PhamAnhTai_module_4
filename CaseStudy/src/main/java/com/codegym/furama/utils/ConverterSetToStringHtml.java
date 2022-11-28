package com.codegym.furama.utils;


import com.codegym.furama.model.contract.ContractDetail;

import java.util.Set;

public class ConverterSetToStringHtml {
    public static String converterTable(Set<ContractDetail> set) {
        StringBuilder builder = new StringBuilder();
        for (ContractDetail contractDetails : set) {
            builder.append("<tr>");
            builder.append("<td>").append(contractDetails.getAttachService().getName()).append("</td>");
            builder.append("<td>").append(contractDetails.getQuantity()).append("</td>");
            builder.append("</tr>");
        }
        return builder.toString();
    }
}
