package service;

import configuration.Configuration;
import configuration.sport.SportConfig;
import model.MatchResult;
import service.mapper.SportMapperService;

import java.util.ArrayList;
import java.util.List;

public class SportService implements IService<MatchResult> {
    private SportConfig sportConfig;
    private SportMapperService sportMapper;
    public SportService() throws Exception {
        sportConfig = new Configuration().getSportConfig();
        sportMapper = new SportMapperService();
    }
    @Override
    public List<MatchResult> getAll() throws Exception {
        var sportInfo = new ArrayList<MatchResult>();
        for (var sportApi : sportConfig.getSportapis()) {
            var items = ReaderService.getMatchResultFromAPI(sportApi);
            var mappedItems = sportMapper.mapObjects(items, sportApi.getMapper());
            sportInfo.addAll(mappedItems);
        }
        return sportInfo;
    }
}
