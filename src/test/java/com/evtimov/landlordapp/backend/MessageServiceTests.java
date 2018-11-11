package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.services.MessageServiceImpl;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTests {
    @Mock
    MessageRepository mockRepository;

    @Mock
    MessageService messageService;

    @InjectMocks
    MessageServiceImpl mockService;

    private List<Message> testList;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void verifyServiceCreatesAndSaveMessage(){
        Message message = mock(Message.class);
        messageService.createMessage(message);
        verify(messageService,times(1))
                .createMessage(message);
        mockRepository.createMessage(message);
        verify(mockRepository,times(1))
                .createMessage(message);
    }

    @Test
    public void getMessagesBySenderIdAndChatId_shouldReturn_specificMessages(){
        List<Message> testList = new ArrayList<>();
        testList.add(new Message("10/01/2010","alabala",1,2,1));
        testList.add(new Message("10/01/2010","balalala",1,2,1));
        testList.add(new Message("10/01/2010","qwqwfv",1,2,1));
        Mockito.when(mockService.getMessagesBySenderIdAndChatId(1,1))
                .thenReturn(testList);
        List<Message> result = mockService.getMessagesBySenderIdAndChatId(1,1);

        Assert.assertEquals(3,result.size());
    }
    @Test
    public void getMessagesByReceiverIdAndChatId_shouldReturn_specificMessages(){
        List<Message> testList = new ArrayList<>();
        testList.add(new Message("10/01/2010","alabala",1,2,1));
        testList.add(new Message("10/01/2010","balalala",1,2,1));
        testList.add(new Message("10/01/2010","qwqwfv",1,2,1));
        testList.add(new Message("10/01/2010","qwerty",1,2,1));
        Mockito.when(mockService.getMessagesByReceiverIdAndChatId(1,1))
                .thenReturn(testList);
        List<Message> result = mockService.getMessagesByReceiverIdAndChatId(1,1);

        Assert.assertEquals(4,result.size());
    }
    @Test
    public void getMessagesByChatId_shouldReturn_specificMessages(){
        List<Message> testList = new ArrayList<>();
        testList.add(new Message("10/01/2010","alabala",1,2,1));
        testList.add(new Message("10/01/2010","balalala",1,2,1));
        testList.add(new Message("10/01/2010","qwqwfv",1,2,1));
        testList.add(new Message("10/01/2010","qwerty",1,2,1));
        testList.add(new Message("10/01/2010","qwerty",1,2,1));
        Mockito.when(mockService.getMessagesByChatId(1))
                .thenReturn(testList);

        List<Message> result = mockService.getMessagesByChatId(1);

        Assert.assertEquals(5,result.size());
    }

}
