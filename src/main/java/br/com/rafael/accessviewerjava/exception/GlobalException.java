//package br.com.rafael.accessviewerjava.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.HashMap;
//import java.util.List;
//
////é responsavel por capturar/tratar todos os erros da aplicação
////para o @override funcionar tem que fazer este extends
//@ControllerAdvice
//public class GlobalException extends ResponseEntityExceptionHandler {
//
//    //MethodArgumentNotValidException
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
//
//        final HashMap<String, HashMap<String, String>> returnObject = new HashMap<>();
//        final HashMap<String, String> allErrorsObject = new HashMap<>();
//
//        final List<ObjectError> allErrorsList = ex.getAllErrors();
//
//        allErrorsList.forEach(error -> {
//            if (error instanceof FieldError) {
//                allErrorsObject.put(((FieldError) error).getField(), error.getDefaultMessage());
//            } else {
//                allErrorsObject.put(error.getObjectName(), error.getDefaultMessage());
//            }
//        });
//
//        returnObject.put("message", allErrorsObject);
//
//        return new ResponseEntity<>(returnObject, HttpStatus.BAD_REQUEST);
//
//    }
//
//    //tratar AppException
//    @ExceptionHandler({AppException.class})
//    public ResponseEntity<Object> handleAppException(final AppException ex) {
//
//        final HashMap<String, String> returnObject = new HashMap<>();
//        returnObject.put("message", ex.getMessage());
//
//        System.out.println(ex.getMessage());
//
//        return  new ResponseEntity<>(returnObject, ex.getStatusCode());
//    }
//
//
//
////    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
////        String errorMessage = ex.getMessage(); // Obtém a mensagem de erro original
////        // Você pode fazer algo com a mensagem de erro aqui, se necessário
////
////        // Agora, retorne a mensagem de erro original como parte da resposta
////        return new ResponseEntity<>(errorMessage, headers, status);
////    }
////
////    @ExceptionHandler(DataIntegrityViolationException.class)
////    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
////        // Você pode personalizar ainda mais a resposta, se desejar
////        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
////    }
////    exceção padão do java (RuntimeException)
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleInternal(final RuntimeException ex) {
//
//        final HashMap<String, String> returnObject = new HashMap<>();
//        returnObject.put("message", "Unknown error occurred");
//
//        return  new ResponseEntity<>(returnObject, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//}
