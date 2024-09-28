package com.lament.z.bitmagic.samples;


import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import sun.misc.Unsafe;

/**
 * original code from https://github.com/gunnarmorling/1brc/blob/main/src/main/java/dev/morling/onebrc/CalculateAverage_thomaswue.java
 *
 * 以 CalculateAverage_thomaswue 中的代码为例，结合隔壁我准备的 bit twiddling hacks 的 demo 解析。
 * */
public class EndianDemo {

	// file.txt 的内容: 0123456789abcdefg
	private static final String FILE = "file.txt";

	public static void main(String[] args) {
		showEndian();
	}

	public static void showEndian(){

		System.out.println("Native Order: " + ByteOrder.nativeOrder());
		System.out.println("System Property-sun.cpu.endian: " + System.getProperty("sun.cpu.endian"));

		int n = 123456789;
		System.out.println("int n = 123456789 Binary: " + Integer.toBinaryString(n));
		// 0000 0111         01011011  11001101  00010101
		// 0x7 最高有效字节 MSB   | 0x5b    | 0xcd    | 0x15 最低有效字节 LSB
		byte[] bytes = ByteBuffer.allocate(4).putInt(n).array();

		if (bytes[0] == 0x7){
			System.out.println("Put n into ByteBuffer, MSB in bytes[0], Big Endian");
		}

		byte[] bytes2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(n).array();
		if (bytes2[0] == 0x15){
			System.out.println("Put n into ByteBuffer, and set LITTLE_ENDIAN  to order,LSB in bytes2[0], Little Endian");
		}

		System.out.println("let's read data from file.txt,which is 0123456789abcdefg");

		System.out.println("----------- MappedByteBuffer ----------------");
		usingMappedByteBuffer();
		System.out.println("----------- Unsafe ----------------");
		usingUnsafe();
	}



	private static void usingMappedByteBuffer(){
		try {
			FileChannel fc = FileChannel.open(java.nio.file.Paths.get(FILE));
			long fileSize = fc.size();
			MappedByteBuffer mapped = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
			String order = mapped.order().toString();
			System.out.println("MappedByteBuffer default Order: " + order);
			long data = mapped.getLong();
			System.out.println("getLong: " + Long.toBinaryString(data));
			System.out.println("00110000 | 00110001 | 00110010 | 00110011 | 00110100 | 00110101 | 00110110 | 00110111");
			System.out.println("  0(MSB) |   1      |   2      |   3      |   4      |   5      |   6      |   7(LSB) ");

			mapped.flip();

			mapped.order(ByteOrder.LITTLE_ENDIAN);
			long data2 = mapped.getLong();
			System.out.println("MappedByteBuffer Change Order: " + mapped.order().toString());
			System.out.println("getLong: " + Long.toBinaryString(data2));
			System.out.println("00110111 | 00110110 | 00110101 | 00110100 | 00110011 | 00110010 | 00110001 | 00110000");
			System.out.println(" 7(LSB)  |    6     |    5     |   4      |     3    |     2    |   1      |   0 (MSB) ");


		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void usingUnsafe() {
		FileChannel fc = null;
		try {
			System.out.println("Using Unsafe.");
			fc = FileChannel.open(java.nio.file.Paths.get(FILE));
			long fileSize = fc.size();
			MemorySegment memSegment = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize, Arena.global());
			long start = memSegment.address();
			long data = MemReader.UNSAFE.getLong(start);
			System.out.println("Order:" + memSegment.asByteBuffer().order().toString());
			System.out.println("Unsafe.getLong: " + Long.toBinaryString(data));
			System.out.println("00110111 | 00110110 | 00110101 | 00110100 | 00110011 | 00110010 | 00110001 | 00110000");
			System.out.println(" 7(LSB)  |    6     |    5     |   4      |     3    |     2    |   1      |   0 (MSB) ");
            System.out.println("Little Endian");

		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	// same reader from 1brc-lament
	private static class MemReader{

		private static final Unsafe UNSAFE = init();

		private static Unsafe init() {
			Field f;
			try {
				f = Unsafe.class.getDeclaredField("theUnsafe");
				f.setAccessible(true);
				return (Unsafe) f.get(Unsafe.class);
			}
			catch (NoSuchFieldException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}


}
