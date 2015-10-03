package com.jasonyoon.tetrismotion;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;

public class SampleListener extends Listener {

    public void onConnect(Controller controller) {
        System.out.println("Connected");

        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);

        controller.config().setFloat("Gesture.Circle.MinRadius", 15.0f);
    }

    public void onFrame(Controller controller) {
//        System.out.println("Frame available");

        Frame frame = controller.frame();

//        System.out.println("Frame id: " + frame.id()
//                + ", timestamp: " + frame.timestamp()
//                + ", hands: " + frame.hands().count()
//                + ", fingers: " + frame.fingers().count()
//                + ", tools: " + frame.tools().count()
//                + ", gestures " + frame.gestures().count());

        for(Gesture gesture : frame.gestures())
        {
            switch (gesture.type()) {
                case TYPE_CIRCLE:
                    System.out.println("circle");
                    break;
                case TYPE_KEY_TAP:
                    System.out.println("key tap");
                    break;
                case TYPE_SCREEN_TAP:
                    System.out.println("screen tap");
                    break;
                case TYPE_SWIPE:
                    System.out.println("swipe");
                    break;
                default:
                    //Handle unrecognized gestures
                    break;
            }
        }
    }
}

