package com.alekseytyan.service.implementation;

import com.alekseytyan.dao.api.MapDao;
import com.alekseytyan.dto.MapDTO;
import com.alekseytyan.entity.Map;
import com.alekseytyan.service.api.MapService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl extends AbstractServiceImpl<Map, MapDao, MapDTO, Long> implements MapService {
    public MapServiceImpl(MapDao dao, ModelMapper mapper) {
        super(dao, mapper, MapDTO.class, Map.class);
    }
}