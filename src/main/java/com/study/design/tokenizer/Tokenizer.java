package com.study.design.tokenizer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author haoxiaoxia
 * @date 2019-09-28 10:14:57
 */
public class Tokenizer {

    private Map<Character,Object> dictionary;

    public Tokenizer(String dictionaryFilePath) throws IOException{
        //红黑树的实现
        dictionary = new TreeMap<>();
        //从文件加载字典到treeMap
        this.loadDictionary(dictionaryFilePath);
    }

    private void loadDictionary(String dictionaryFilePath) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dictionaryFilePath)));
        String line = null;
        while((line = reader.readLine()) != null){
            line = line.trim();
            if(line.length() == 0){
                continue;
            }
            char c;
            Map<Character,Object> child = this.dictionary;
            //组成以这个字符开头的词的数
            for(int i = 0;i<line.length();i++){
                c=line.charAt(i);
                Map<Character,Object> ccMap = (Map<Character,Object>)child.get(c);
                 if(ccMap == null){
                    ccMap = new HashMap<Character,Object>();
                    child.put(c,ccMap);
                }
                child = ccMap;
            }
        }
    }

    public List<String> partciple(String text){
        if(text == null){
            return null;
        }
        text = text.trim();
        if(text.length() == 0){
            return null;
        }
        List<String> tokens = new ArrayList<>();
        char c;
          for (int i=0;i<text.length();){
            StringBuilder token = new StringBuilder();
            Map<Character,Object> child = this.dictionary;
            boolean matchToken = false;
            for(int j=i;j<text.length();j++){
                c=text.charAt(j);
                token.append(c);
                Map<Character,Object> ccMap = (Map<Character,Object>)child.get(c);
                if(ccMap == null){
                    break;
                }
                if(ccMap.isEmpty()){
                    matchToken = true;
                    i = j+1;
                    break;
                }
                child = ccMap;
            }
            if(matchToken){
                tokens.add(token.toString());
            }else{
                tokens.add(""+text.charAt(i));
                i++;
            }
        }
        return tokens;
    }

    public static void main(String[] args) throws IOException{
        Tokenizer tk = new Tokenizer(Tokenizer.class.getResource("dictionary.txt").getPath());
        List<String> tokens = tk.partciple("张三说的确实在里，我爱中国，王美丽");
        for(String s : tokens){
            System.out.println(s);
        }
    }

}
