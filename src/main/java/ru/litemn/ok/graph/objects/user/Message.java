package ru.litemn.ok.graph.objects.user;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Message
 */
public class Message {
    private String text;
    private long seq;
    private String mid;

    public String getText() {
        return text;
    }

    public long getSeq() {
        return seq;
    }

    public String getMid() {
        return mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return seq == message.seq &&
                Objects.equal(text, message.text) &&
                Objects.equal(mid, message.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text, seq, mid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("text", text)
                .add("seq", seq)
                .add("mid", mid)
                .toString();
    }
}
