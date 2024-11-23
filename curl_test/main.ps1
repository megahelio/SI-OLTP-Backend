function Test-ApiEntity {
    param (
        [string]$method,
        [string]$entityName,
        [string]$entityApiUrl, # URL específica para cada entidad
        [string]$entityDataFilePath,
        [string]$expectedResponseFilePath
    )

    Write-Host "Testing CRUD operations for entity: $entityName"

    if ($method -ne "Get" -and $method -ne "Delete") {
        Write-Host $method
        # Leer el contenido de los archivos JSON (Datos de entrada y resultado esperado)
        $entityData = Get-Content -Path $entityDataFilePath -Raw
    }
#     $expectedResponse = Get-Content -Path $expectedResponseFilePath -Raw
    $expectedResponse = ""

    if ($method -eq "Get") {
        # ------------------- READ (GET) -------------------
        $getResponse = Invoke-RestMethod -Uri "$entityApiUrl" -Method GET
        if ($getResponse -eq $expectedResponse) {
            Write-Host "$entityName READ: Success"
        }
        else {
            Write-Host "$entityName READ: Failed"
            Write-Host "Expected: $expectedResponse"
            Write-Host "Received: $getResponse"
        }
    }
    
    if ($method -eq "Post") {
        # ------------------- CREATE (POST) -------------------
        $createResponse = Invoke-RestMethod -Uri "$entityApiUrl" -Method Post -ContentType "application/json" -Body $entityData
        if ($createResponse -eq $expectedResponse) {
            Write-Host "$entityName CREATE: Success"
        }
        else {
            Write-Host "$entityName CREATE: Failed"
            Write-Host "Expected: $expectedResponse"
            Write-Host "Received: $createResponse"
        }
    }

    if ($method -eq "Put") {
        # ------------------- UPDATE (PUT) -------------------
        $updateResponse = Invoke-RestMethod -Uri "$entityApiUrl" -Method Put -ContentType "application/json" -Body $entityData
        if ($updateResponse -eq $expectedResponse) {
            Write-Host "$entityName UPDATE: Success"
        }
        else {
            Write-Host "$entityName UPDATE: Failed"
            Write-Host "Expected: $expectedResponse"
            Write-Host "Received: $updateResponse"
        }
    }
    if ($method -eq "Delete") {
        # ------------------- DELETE -------------------
        $deleteResponse = Invoke-RestMethod -Uri "$entityApiUrl" -Method Delete
        if ($deleteResponse -eq $expectedResponse) {
            Write-Host "$entityName DELETE: Success"
        }
        else {
            Write-Host "$entityName DELETE: Failed"
            Write-Host "Expected: $expectedResponse"
            Write-Host "Received: $deleteResponse"
        }
    }
}

# Define the entities to test, each with their respective data, expected results, and API URL
$entities = @(
    @{
        "name"         = "drugs_getAll";
        "apiUrl"       = "http://localhost:8080/drugs";
        "dataFile"     = "";
        "expectedFile" = "expected_drugs_getAll_data.json";
        "method"    = "Get"
    },
    @{
        "name"         = "drugs_post";
        "apiUrl"       = "http://localhost:8080/drugs";
        "dataFile"     = "drugs_post_data.json";
        "expectedFile" = "expected_drugs_post_data.json"
        "method"    = "Post"
    }
)

# Run the CRUD tests for each entity
foreach ($entity in $entities) {
    Test-ApiEntity -entityName $entity.name -entityApiUrl $entity.apiUrl -entityDataFilePath $entity.dataFile -expectedResponseFilePath $entity.expectedFile -method $entity.method
}
