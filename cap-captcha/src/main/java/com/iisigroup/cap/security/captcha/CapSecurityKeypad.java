package com.iisigroup.cap.security.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import nl.captcha.Captcha;
import nl.captcha.Captcha.Builder;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.gimpy.GimpyRenderer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.text.renderer.WordRenderer;

import org.apache.commons.codec.binary.Base64;

import com.iisigroup.cap.security.captcha.producer.CapTextProducer;


/**
 * <pre>
 * Cap Security keypad image generate
 * </pre>
 * 
 * @since 2012/10/19
 * @author rodeschen
 * @version <ul>
 *          <li>2012/10/19,rodeschen,new
 *          </ul>
 */
public class CapSecurityKeypad {

	private static final Random RAND = new SecureRandom();
	private String metadata;
	private int height;
	private int width;
	private boolean border;
	private WordRenderer wordRenderer;
	private List<Object> producers;
	private String chars;
	private List<String> words;
	private boolean random = true;

	public class SecurityKey {
		private List<? extends Object> base64Image;
		private List<String> answer;

		public SecurityKey(List<? extends Object> base64Image,
				List<String> answer) {
			this.base64Image = base64Image;
			this.answer = answer;
		}

		/**
		 * @return the base64Image
		 */
		@SuppressWarnings("unchecked")
		public <T> T getImages() {
			return (T) base64Image;
		}

		/**
		 * @return the answer
		 */
		public List<String> getAnswer() {
			return answer;
		}

	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(boolean random) {
		this.random = random;
	}

	/**
	 * @param mataData
	 *            the mataData to set
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the generateStr
	 */
	public String getChars() {
		return chars;
	}

	/**
	 * @param generateStr
	 *            the generateStr to set
	 */
	public void setChars(String chars) {
		this.chars = chars;
		words = new ArrayList<String>();
		for (byte b : chars.getBytes()) {
			words.add(String.valueOf((char) b));
		}
	}

	/**
	 * @param wordRenderer
	 *            the wordRenderer to set
	 */
	public void setWordRenderer(WordRenderer wordRenderer) {
		this.wordRenderer = wordRenderer;
	}

	/**
	 * @return the addBorder
	 */
	public boolean isBorder() {
		return border;
	}

	/**
	 * @param addBorder
	 *            the addBorder to set
	 */
	public void setBorder(boolean border) {
		this.border = border;
	}

	/**
	 * generateBase64String
	 * 
	 * @return
	 */
	public SecurityKey generateBase64String() {
		return generate(1);
	}

	/**
	 * generateByteArray
	 * 
	 * @return
	 */
	public SecurityKey generateByteArray() {
		return generate(2);
	}

	private SecurityKey generate(int type) {
		List<String> words = getWords();
		List<String> answer = new ArrayList<String>();
		List<Object> base64Image = new ArrayList<Object>();
		while (!words.isEmpty()) {
			int randomInt = random ? RAND.nextInt(words.size()) : 0;
			// shift render number
			String value = words.remove(randomInt);
			answer.add(value);
			BufferedImage bi = crateImage(value);
			Object obj = null;
			switch (type) {
			case 1:// base64String
				obj = convertImage(bi, true);
				break;
			case 2:// byteArray
				obj = convertImage(bi, false);
				break;
			}
			base64Image.add(obj);
		}

		return new SecurityKey(base64Image, answer);
	}

	@SuppressWarnings("unchecked")
	private <T> T convertImage(BufferedImage image, boolean toBase64) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Object resStr = null;
		try {
			ImageIO.write(image, this.metadata, baos);
			baos.flush();
			if (toBase64) {
				resStr = Base64.encodeBase64String(baos.toByteArray());
			} else {
				resStr = baos.toByteArray();
			}

		} catch (IOException e) {
			// set default number base64 str ;
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (T) resStr;
	}

	/**
	 * @param producers
	 *            the producers to set
	 */
	public void setProducers(List<Object> producers) {
		this.producers = producers;
	}

	private BufferedImage crateImage(String str) {
		Builder captcha = new Captcha.Builder(width, height);
		if (this.wordRenderer == null) {
			captcha.addText(new CapTextProducer(str));
		} else {
			captcha.addText(new CapTextProducer(str), this.wordRenderer);
		}

		if (producers != null && !producers.isEmpty()) {
			for (Object producer : producers) {
				if (producer instanceof BackgroundProducer) {
					captcha.addBackground((BackgroundProducer) producer);
				} else if (producer instanceof GimpyRenderer) {
					captcha.gimp((GimpyRenderer) producer);
				} else if (producer instanceof NoiseProducer) {
					captcha.addNoise((NoiseProducer) producer);
				}

			}
		}
		if (isBorder()) {
			captcha.addBorder();
		}
		return captcha.build().getImage();
	}

	private List<String> getWords() {
		return new LinkedList<String>(words);
	}

}