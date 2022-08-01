package com.brid.service.impl;

import com.brid.service.Tweetable;

/**
 * @author ImOkkkk
 * @date 2022/6/2 14:50
 * @since 1.0
 */
public class TweetAbility implements Tweetable {

  @Override
  public void tweet() {
    System.out.println("tweet...");
  }
}
