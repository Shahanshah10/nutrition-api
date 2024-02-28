package com.wishlist.service;


import com.wishlist.model.DbSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.wishlist.constants.WishListConstants.ID;
import static com.wishlist.constants.WishListConstants.SEQ;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


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
