package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MessageData;
import com.example.myapplication.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter {


    private Context context;
    private List<MessageData> messageData;

    private final int senderViewType = 1;
    private final int receiverViewType = 2;
    private final int picSenderViewType = 3;
    private final int picReceiverViewType = 4;

    public RoomAdapter(Context context, List<MessageData> messageData) {
        this.context = context;
        this.messageData = messageData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == senderViewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.send_message, parent, false);
            // SenderMessageViewHolder senderMessageViewHolder = new SenderMessageViewHolder(view); // old way
            return new SenderMessageViewHolder(view);
        } else if (viewType == receiverViewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.received_message, parent, false);
            return new ReceiverMessageViewHolder(view);
        } else if (viewType == picSenderViewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.room_photo_send, parent, false);
            return new SenderPhotoMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.room_photo_receive, parent, false);
            return new ReceiverPhotoMessageViewHolder(view);
        }
    }

    // ((SenderMessageViewHolder) holder) ->  meaning
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getClass() == SenderMessageViewHolder.class) {
            ((SenderMessageViewHolder) holder).senderMessage.setText(messageData.get(position).getMessage());
            ((SenderMessageViewHolder) holder).senderTime.setText(messageData.get(position).getTimeStamp());
        } else if (holder.getClass() == ReceiverMessageViewHolder.class) {
            ((ReceiverMessageViewHolder) holder).receiverMessage.setText(messageData.get(position).getMessage());
            ((ReceiverMessageViewHolder) holder).receiverTime.setText(messageData.get(position).getTimeStamp());
        } else if (holder.getClass() == SenderPhotoMessageViewHolder.class) {
            ((SenderPhotoMessageViewHolder) holder).senderPhotoTime.setText(messageData.get(position).getTimeStamp());
            Glide.with(context)
                    .asBitmap()
                    .load(messageData.get(position).getMessage())
                    .placeholder(R.drawable.send_photo_src)
                    .into(((SenderPhotoMessageViewHolder) holder).senderPhotoImage);
        } else {
            ((ReceiverPhotoMessageViewHolder) holder).receiverPhotoTime.setText(messageData.get(position).getTimeStamp());
            Glide.with(context)
                    .asBitmap()
                    .load(messageData.get(position).getMessage())
                    .placeholder(R.drawable.send_photo_src)
                    .into(((ReceiverPhotoMessageViewHolder) holder).receiverPhotoImage);
        }
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        String currentUserId = "1";
        if (messageData.get(position).getMessageType().equals("normal")) {
            if (messageData.get(position).getSenderId().equals(currentUserId)) {
                return senderViewType;
            }
            return receiverViewType;
        } else {
            if (messageData.get(position).getSenderId().equals(currentUserId)) {
                return picSenderViewType;
            }
            return picReceiverViewType;
        }
    }

    @Override
    public int getItemCount() {
        return messageData.size();
    }

    // sender
    public static class SenderMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView senderMessage;
        private TextView senderTime;

        public SenderMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMessage = itemView.findViewById(R.id.sender_message);
            senderTime = itemView.findViewById(R.id.sender_time);
        }
    }

    // receiver
    public static class ReceiverMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView receiverMessage;
        private TextView receiverTime;

        public ReceiverMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverMessage = itemView.findViewById(R.id.received_message);
            receiverTime = itemView.findViewById(R.id.received_time);
        }
    }

    // photoSender

    public static class SenderPhotoMessageViewHolder extends RecyclerView.ViewHolder {
        private ImageView senderPhotoImage;
        private TextView senderPhotoTime;

        public SenderPhotoMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderPhotoImage = itemView.findViewById(R.id.s_image);
            senderPhotoTime = itemView.findViewById(R.id.s_photo_time);
        }
    }

    // photoReceiver
    public static class ReceiverPhotoMessageViewHolder extends RecyclerView.ViewHolder {
        private ImageView receiverPhotoImage;
        private TextView receiverPhotoTime;

        public ReceiverPhotoMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverPhotoImage = itemView.findViewById(R.id.r_image);
            receiverPhotoTime = itemView.findViewById(R.id.r_photo_time);
        }
    }

}
