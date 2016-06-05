package org.songdan.mock.dao;

import org.songdan.mock.model.Message;

/**
 * Created by PC on 2016/6/5.
 */
public interface IMessageDAO {

    int saveMessage(Message message);

}
