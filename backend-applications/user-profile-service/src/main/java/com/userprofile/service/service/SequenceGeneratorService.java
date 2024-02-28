package com.userprofile.service.service;

import com.userprofile.service.model.DbSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static com.userprofile.service.constants.UserProfileConstants.ID;
import static com.userprofile.service.constants.UserProfileConstants.SEQ;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {

    private final MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(sequenceName));
        Update update = new Update();
        update.inc(SEQ, 1);
        DbSequence dbSequence = mongoOperations.
                findAndModify(query, update, options().returnNew(true).upsert(true), DbSequence.class);
        return !Objects.isNull(dbSequence) ? dbSequence.getSeq() : 1;
    }
}