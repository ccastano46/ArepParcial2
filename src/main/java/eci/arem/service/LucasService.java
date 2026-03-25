package eci.arem.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class LucasService {
    private int l0 = 2;
    private int l1 = 1;
    private int lucasSequence(int n) throws Exception{
        if (n < 0) return 0;
        else if(n == 0) return 2;
        else if(n == 1) return 1;
        else return lucasSequence(n - 1) + lucasSequence(n -2 );
    }

    public String writeSequence(int n) throws Exception{
        if (n < 0) return "";
        StringBuffer sequence = new StringBuffer();
        for(int i = 0; i <= n; i++){
            sequence.append(lucasSequence(i));
            if(i < n) sequence.append(" ");
        }
        return sequence.toString();
    }


}
