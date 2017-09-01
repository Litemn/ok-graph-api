package ru.litemn.ok.graph;

import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import ru.litemn.ok.graph.objects.user.Chat;
import ru.litemn.ok.graph.objects.user.ChatAction;
import ru.litemn.ok.graph.objects.user.Chats;
import ru.litemn.ok.graph.objects.user.Info;
import ru.litemn.ok.graph.objects.user.Messages;
import ru.litemn.ok.graph.objects.user.MessagesActionResult;
import ru.litemn.ok.graph.objects.user.Recipient;
import ru.litemn.ok.graph.objects.user.Subscriptions;
import ru.litemn.ok.graph.objects.user.actions.MessageAction;
import ru.litemn.ok.graph.requests.user.ChatRequest;
import ru.litemn.ok.graph.requests.user.ChatsRequest;
import ru.litemn.ok.graph.requests.user.InfoRequest;
import ru.litemn.ok.graph.requests.user.MessagesActionRequest;
import ru.litemn.ok.graph.requests.user.MessagesRequest;
import ru.litemn.ok.graph.requests.user.SubscribeRequest;
import ru.litemn.ok.graph.requests.user.SubscriptionsRequest;
import ru.litemn.ok.graph.requests.user.UnsubscribeRequest;

/**
 * ok graph-api client
 */
public class OkClient {

    private final String token;
    private final CloseableHttpClient client;
    private final Gson gson;

    public OkClient(String token, CloseableHttpClient client) {
        this.token = token;
        this.client = client;
        this.gson = new Gson();
    }

    public OkClient(String token) {
        this.token = token;
        this.client = HttpClients.createDefault();
        this.gson = new Gson();
    }

   public Info getTokenInfo() {
       InfoRequest infoRequest = new InfoRequest(gson, client, token);
       return infoRequest.execute();
   }

   public Chat getChatById(String chatId) {
       ChatRequest chatRequest = new ChatRequest(gson, client, token, chatId);
       return chatRequest.execute();
   }

   public Chats getChats() {
       ChatsRequest chatsRequest = new ChatsRequest(gson, client, token);
       return chatsRequest.execute();
   }

   public Chats getChats(String marker, int count) {
       ChatsRequest chatsRequest = new ChatsRequest(gson, client, token, marker, count);
       return chatsRequest.execute();
   }

    public Chats getChats(String marker) {
        ChatsRequest chatsRequest = new ChatsRequest(gson, client, token, marker, 50);
        return chatsRequest.execute();
    }

    public Chats getChats(int count) {
        ChatsRequest chatsRequest = new ChatsRequest(gson, client, token, count);
        return chatsRequest.execute();
    }

    public Messages getMessages(String chatId) {
        MessagesRequest messagesRequest = new MessagesRequest(gson, client, token, chatId);
        return messagesRequest.execute();
    }

    public Messages getMessages(String chatId, long from, long to, long count) {
        MessagesRequest messagesRequest = new MessagesRequest(gson, client, token, chatId, from, to, count);
        return messagesRequest.execute();
    }

    public Messages getMessages(String chatId, long count) {
        MessagesRequest messagesRequest = new MessagesRequest(gson, client, token, chatId, Long.MAX_VALUE, 0, count);
        return messagesRequest.execute();
    }

    public boolean subscribe(String url) {
        SubscribeRequest subscribeRequest = new SubscribeRequest(gson, client, token, url);
        return subscribeRequest.execute().isSuccess();
    }

    public boolean unsubscribe(String url) {
        UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest(gson, client, token, url);
        return unsubscribeRequest.execute().isSuccess();
    }

    public Subscriptions getSubscription() {
        SubscriptionsRequest subscriptionsRequest = new SubscriptionsRequest(gson, client, token);
        return subscriptionsRequest.execute();
    }


    public MessagesActionResult sendMessage(String chatId, String text) {
        MessagesActionRequest messagesAcionRequest = new MessagesActionRequest(gson, client, token, new ChatAction(new MessageAction(text), new Recipient(chatId)));
        return messagesAcionRequest.execute();
    }

}
