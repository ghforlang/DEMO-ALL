package com.edu.nbu.cn.datatransfer.db.parser;

import com.edu.nbu.cn.datatransfer.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

/**
* @author laoshi . hua
* @since 1.0 
* @version 1.0 2022/3/22-3:54 下午
*/public class TableNameParser extends NameParser{
    private static final String WORD_SEPARATOR = "_";

    @Override
    public String parse(String s) {
        if(StringUtils.isBlank(s) || s.startsWith(WORD_SEPARATOR) || s.endsWith(WORD_SEPARATOR)){
            throw new IllegalNameException("illegal name [" + s +  "]!");
        }
        StringBuffer sb = new StringBuffer();

        if(s.contains(WORD_SEPARATOR)){
            String[] words = StringUtils.split(s,WORD_SEPARATOR);
            sb.append(words[0]);
            for(int i=1;i<words.length;i++){
                if(!Character.isLowerCase(words[i].charAt(0))){
                    throw new IllegalNameException("illegal character " + words[i].charAt(0) + "in name [" + s +  "]!");
                }
                sb.append(words[i].substring(0,1).toUpperCase() + words[i].substring(1));
            }
        }else{
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TableNameParser parser = new TableNameParser();
        String[] names = {"aaa","aaa_bbb","aaa_bbb_ccc","aaa_bbb_ccc_ddd"};
        for (int i=0;i<names.length;i++){
            System.out.println(parser.parse(names[i]));
        }
    }
}
