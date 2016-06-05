package org.songdan.mock.dao.impl;

import org.songdan.mock.dao.IMessageDAO;
import org.songdan.mock.model.Message;
import org.songdan.mock.service.IMessageService;
import org.springframework.stereotype.Repository;

/**
 * Created by PC on 2016/6/5.
 */
@Repository
public class MessageDAOImpl implements IMessageDAO {

    @Override
    public int saveMessage(Message message) {
        /*
        操作数据库
         */
        return 1;
    }
}
