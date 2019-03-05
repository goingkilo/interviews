package crypto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class OneTimePad {

    private static final int RANGE = 10000;
    public static final String CIPHER_FILE = "/tmp/cipher.0.txt";
    public static final String DECIPHER_FILE = "/tmp/cipher.1.txt";
    public static final String CIPHERTEXT_FILE = "/tmp/ciphertext.0.txt";
    public static final int DEFAULT_KEY_SIZE = 100;

    private Set<String> keySet;
    private Map<Character,String> cipher;
    private Map<String,Character> decipher;

    public OneTimePad(){
        this(DEFAULT_KEY_SIZE);
    }
    public OneTimePad(int keySize) {
        keySet = new HashSet<>();

        cipher = new HashMap<>();

        decipher = new HashMap<>();
        java.util.Random r = new Random(System.currentTimeMillis());

        while ( keySet.size() !=  keySize) {
            keySet.add(String.valueOf(r.nextInt(RANGE)));
        }
    }

    public String encrypt(String document) throws InsufficientCipherLengthException {
        StringBuilder s = new StringBuilder();
        for( char c : document.toCharArray()) {
            System.out.print( "["+c+"]");
            if( cipher.containsKey(c)){
                s.append( cipher.get(c));
                s.append( " ");
            }
            else {
                if( keySet.size() == 0)
                    throw new InsufficientCipherLengthException("Insufficient cipher size");

                String k0 = keySet.iterator().next();
                keySet.remove(k0);
                cipher.put( c, k0);
                decipher.put(k0, c);

                s.append(k0);
            }
        }
        return s.toString();
    }

    public void saveCipher() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(cipher);
        FileOutputStream fos = new FileOutputStream( new File(CIPHER_FILE));
        fos.write( json.getBytes());
        fos.close();
        fos.flush();

        String json1 = gson.toJson(decipher);
        FileOutputStream fos1 = new FileOutputStream( new File(DECIPHER_FILE));
        fos1.write( json1.getBytes());
        fos1.close();
        fos1.flush();
    }

    public void saveCipherText(String s) throws IOException {
        FileOutputStream fos = new FileOutputStream( new File(CIPHERTEXT_FILE));
        fos.write( s.getBytes());
        fos.close();
        fos.flush();
    }

    public void decrypt( ) throws IOException {
        decrypt( CIPHERTEXT_FILE, DECIPHER_FILE);
    }

    public void decrypt( String cipherTextFile, String decipherFile) throws IOException {

        String cipherText = new String(Files.readAllBytes(new File(cipherTextFile).toPath()));

        String cipherString = new String(Files.readAllBytes(new File(decipherFile).toPath()));
        Gson gson = new Gson();
        Map<String, Character> myCipher = gson.fromJson( cipherString, new TypeToken<Map<String, Character>>(){}.getType());
        for( String s : cipherText.split(" ")){
            Character val = myCipher.get(s);
            if( val == null && s != null) {
                System.out.print( "["+s+"]");
            }
            else {
                System.out.print(val);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException, InsufficientCipherLengthException {
        OneTimePad s = new OneTimePad();
        String ciphertext = s.encrypt(new String(Files.readAllBytes(new File(args[0]).toPath())));

        System.out.println( ciphertext);
        s.saveCipher();
        s.saveCipherText(ciphertext);
        System.out.println( " ** ciphered ** ");
        s.decrypt();
    }

}
