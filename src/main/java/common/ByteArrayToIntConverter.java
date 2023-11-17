package common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.nio.ByteBuffer;

@Converter
public class ByteArrayToIntConverter implements AttributeConverter<Integer, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(Integer integer) {
        // Logic chuyển đổi từ Integer sang byte[]
        //  sử dụng ByteBuffer
        return integer == null ? null : ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(integer).array();
    }

    @Override
    public Integer convertToEntityAttribute(byte[] bytes) {
        // Logic chuyển đổi từ byte[] sang Integer
        //  sử dụng ByteBuffer
        return bytes == null ? null : ByteBuffer.wrap(bytes).getInt();
    }



}
