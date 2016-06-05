package org.songdan.mock.service.impl;

import org.songdan.mock.dao.IMessageDAO;
import org.songdan.mock.model.Message;
import org.songdan.mock.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PC on 2016/6/5.
 */
@Service
public class IMessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDAO messageDAO;

    @Override
    public Message saveMessage(Message message) {
        int result = messageDAO.saveMessage(message);
        if (result == 1) {
            message.setContent(message.getContent() + " after save");
        }
        else {
            message.setContent(message.getContent() + ",save fail");
        }
        return message;
    }
}
