package com.anth0o0ny.backend.converter;

import org.springframework.core.convert.converter.Converter;
import com.anth0o0ny.backend.enums.Rank;

public class StringToRankConverter implements Converter<String, Rank> {

    @Override
    public Rank convert(String source) {
        try {
            return Rank.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Rank.NR;
        }
    }
}