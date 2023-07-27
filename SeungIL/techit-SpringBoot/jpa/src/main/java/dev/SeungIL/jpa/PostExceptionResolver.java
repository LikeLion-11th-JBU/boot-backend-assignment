//package dev.SeungIL.jpa;
//
//import dev.SeungIL.jpa.exception.BaseException;
//import dev.SeungIL.jpa.exception.ErrorResponseDto;
//import dev.SeungIL.jpa.exception.InconsistentDataException;
//import dev.SeungIL.jpa.exception.PostNotExistException;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class PostExceptionResolver extends AbstractHandlerExceptionResolver {
//    @Override
//    protected ModelAndView doResolveException(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object handler,
//            Exception ex) {
//        logger.debug(ex.getClass());
//       if (ex instanceof BaseException) {
//           response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//          try {
//               response.getOutputStream().print(
//                       new ObjectMapper().writeValueAsString(
//                               new ErrorResponseDto("in resolver, message: " + ex.getMessage())
//                       )
//               );
//                response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//               return new ModelAndView();
//            } catch (IOException e) {
//                logger.warn("Handling exception caused exception: {}", e);
//           }
//       }
//        return null;
//    }
//}
