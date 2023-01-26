package com.rongaru.common.lang.utility;

import java.io.InputStream;
import java.io.OutputStream;

public class InputOutputUtility {

    public static final int DEFAULT_BUFFER_SIZE = 1024 * 256; // 256KB

    public static int readBytesToBuffer( InputStream input, byte[] buffer ) {
        return readBytesToBuffer( input, buffer, buffer.length );
    }

    public static void writeBytesFromBuffer( OutputStream output, byte[] buffer ) {
        writeBytesFromBuffer( output, buffer, buffer.length );
    }

    public static int readBytesToBuffer( InputStream input, byte[] buffer, int length ) {
        return TriFunctionUtility.apply( buffer, 0, length, input :: read );
    }

    public static void writeAllBytesToOutputStream( InputStream input, OutputStream output ) {
        writeAllBytesToOutputStream( input, output, new byte[ DEFAULT_BUFFER_SIZE ] );
    }

    public static void writeBytesFromBuffer( OutputStream output, byte[] buffer, int length ) {
        TriConsumerUtility.accept( buffer, 0, Math.max( length, 0 ), output :: write );
    }

    public static void writeAllBytesToOutputStream( InputStream input, OutputStream output, byte[] buffer ) {
        while ( FunctionalUtility.applyThenEvaluate( input, output, buffer, InputOutputUtility :: readBytesToBufferThenWriteToOutputStream, IntegerUtility :: isPositive ) ) ;
    }

    public static int readBytesToBufferThenWriteToOutputStream( InputStream input, OutputStream output, byte[] buffer ) {
        return FunctionalUtility.acceptThenApply( output, buffer, readBytesToBuffer( input, buffer ), InputOutputUtility :: writeBytesFromBuffer, ( arg1, arg2, arg3 ) -> arg3 );
    }

}
