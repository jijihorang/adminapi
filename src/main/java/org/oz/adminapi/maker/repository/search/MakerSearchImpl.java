package org.oz.adminapi.maker.repository.search;

import org.oz.adminapi.maker.domain.MakerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MakerSearchImpl extends QuerydslRepositorySupport implements MakerSearch {
    private static final Logger log = LoggerFactory.getLogger(MakerSearchImpl.class);

    public MakerSearchImpl() {super(MakerEntity.class);}


}
