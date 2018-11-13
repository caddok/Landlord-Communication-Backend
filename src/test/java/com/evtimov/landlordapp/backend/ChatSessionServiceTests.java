package com.evtimov.landlordapp.backend;

import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import com.evtimov.landlordapp.backend.services.ChatSessionServiceImpl;
import com.evtimov.landlordapp.backend.services.base.ChatSessionService;
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
public class ChatSessionServiceTests {
    @Mock
    ChatSessionRepository mockRepository;

    @InjectMocks
    ChatSessionServiceImpl mockService;

    @Mock
    ChatSessionService chatSessionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyChatSessionIsCreated() {
        ChatSession chatSession = mock(ChatSession.class);
        chatSessionService.createChat(chatSession);
        verify(chatSessionService,times(1))
                .createChat(chatSession);
    }

    @Test
    public void verifyChatSessionIsDeleted() {
        ChatSession chatSession = mock(ChatSession.class);
        chatSessionService.deleteChat(chatSession.getChatsessionId());
        verify(chatSessionService,times(1))
                .deleteChat(chatSession.getChatsessionId());
    }

    @Test
    public void getAllByTenantId_shouldReturnAllSession_withSpecificTenantId(){
        List<ChatSession> testList = new ArrayList<>();
        testList.add(new ChatSession("1/1/2001",1,5));
        testList.add(new ChatSession("1/1/2001",1,2));
        testList.add(new ChatSession("1/1/2001",1,3));
        testList.add(new ChatSession("1/1/2001",1,4));
        testList.add(new ChatSession("1/1/2001",1,6));
        Mockito.when(mockService.getAllByTenantId(1))
                .thenReturn(testList);

        List<ChatSession> result = mockService.getAllByTenantId(1);

        Assert.assertEquals(5,result.size());
    }
    @Test
    public void getAllByLandlordId_shouldReturnAllSession_withSpecificTenantId(){
        List<ChatSession> testList = new ArrayList<>();
        testList.add(new ChatSession("1/1/2001",2,1));
        testList.add(new ChatSession("1/1/2001",5,1));
        testList.add(new ChatSession("1/1/2001",7,1));
        testList.add(new ChatSession("1/1/2001",4,1));
        testList.add(new ChatSession("1/1/2001",8,1));
        Mockito.when(mockService.getAllByLandlordId(1))
                .thenReturn(testList);

        List<ChatSession> result = mockService.getAllByLandlordId(1);

        Assert.assertEquals(5,result.size());
    }

    @Test
    public void checkForExisting_shouldReturnTrue_ifChatSessionExists(){
        List<ChatSession> testList = new ArrayList<>();
        testList.add(new ChatSession("1/1/2001",2,1));
        Mockito.when(mockService.checkIfChatSessionExistsByTenantIdAndLandlordId(2,1))
                .thenReturn(testList);

        List<ChatSession> result = mockService.checkIfChatSessionExistsByTenantIdAndLandlordId(2,1);

        Assert.assertEquals(1,result.size());
    }
}
