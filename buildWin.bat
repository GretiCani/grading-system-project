@echo off

call cd "%CD%\configuration-server"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\auth-server"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\discovery-server"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\gateway-service"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\professor-service"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\student-service"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\evaluation-service"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\notification-service"
call mvn "clean" "package" "-DskipTests"
call cd ..
call cd "%CD%\course-service"
call mvn "clean" "package" "-DskipTests"
