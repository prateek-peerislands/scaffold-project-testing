# Helm Deploy Commands

## Standard Helm Upgrade Command

Use this command to deploy or update any application to EKS:

```bash
helm upgrade --install <APP_NAME> ./helm/eks-app \
  --namespace <NAMESPACE> \
  --create-namespace \
  --set app.name=<APP_NAME> \
  --set image.repository=<IMAGE_REPOSITORY> \
  --set image.tag=<IMAGE_TAG> \
  --wait \
  --timeout 5m
```

## Parameters

- `<APP_NAME>`: Application name (used as both Helm release name and app name for labels/selectors)
- `<NAMESPACE>`: Kubernetes namespace (e.g., `default`, `production`, `staging`)
- `<IMAGE_REPOSITORY>`: Full Docker image repository URL (e.g., `123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app`)
- `<IMAGE_TAG>`: Docker image tag (e.g., `v1.0.0`, `abc123def456`, `latest`)

**Note:** The Helm release name is the same as the app name for simplicity and consistency.

## Examples

### Basic Deployment

```bash
helm upgrade --install my-app ./helm/eks-app \
  --namespace default \
  --create-namespace \
  --set app.name=my-app \
  --set image.repository=123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app \
  --set image.tag=v1.0.0 \
  --wait \
  --timeout 5m
```

### With Custom Namespace

```bash
helm upgrade --install my-app ./helm/eks-app \
  --namespace production \
  --create-namespace \
  --set app.name=my-app \
  --set image.repository=123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app \
  --set image.tag=abc123def456 \
  --wait \
  --timeout 5m
```

### With Additional Values File

```bash
helm upgrade --install my-app ./helm/eks-app \
  --namespace production \
  --create-namespace \
  --set app.name=my-app \
  --set image.repository=123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app \
  --set image.tag=v1.0.0 \
  -f values-production.yaml \
  --wait \
  --timeout 5m
```

### Using Full Image URL

```bash
helm upgrade --install my-app ./helm/eks-app \
  --namespace default \
  --create-namespace \
  --set app.name=my-app \
  --set image.repository=123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app \
  --set image.tag=sha-abc123def456 \
  --wait \
  --timeout 5m
```

## Command Breakdown

- `helm upgrade --install`: Upgrades if release exists, installs if it doesn't
- `--namespace <NAMESPACE>`: Target Kubernetes namespace
- `--create-namespace`: Creates namespace if it doesn't exist
- `--set app.name=<APP_NAME>`: Sets the application name
- `--set image.repository=<IMAGE_REPOSITORY>`: Sets the Docker image repository
- `--set image.tag=<IMAGE_TAG>`: Sets the Docker image tag
- `--wait`: Waits for deployment to complete
- `--timeout 5m`: Maximum wait time (5 minutes)

## Environment Variables Version

For use in scripts or CI/CD:

```bash
export APP_NAME="my-app"
export NAMESPACE="production"
export IMAGE_REPOSITORY="123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app"
export IMAGE_TAG="v1.0.0"

helm upgrade --install ${APP_NAME} ./helm/eks-app \
  --namespace ${NAMESPACE} \
  --create-namespace \
  --set app.name=${APP_NAME} \
  --set image.repository=${IMAGE_REPOSITORY} \
  --set image.tag=${IMAGE_TAG} \
  --wait \
  --timeout 5m
```

## One-Liner for Quick Deploy

```bash
helm upgrade --install my-app ./helm/eks-app --namespace default --create-namespace --set app.name=my-app --set image.repository=123456789012.dkr.ecr.us-east-1.amazonaws.com/my-app --set image.tag=v1.0.0 --wait --timeout 5m
```

**Note:** In the command above, `my-app` is used for both the Helm release name and the app name.

## Verification Commands

After deployment, verify with:

```bash
# Check Helm release status
helm status my-app -n default

# Check pods
kubectl get pods -l app.kubernetes.io/name=my-app -n default

# Check deployment
kubectl get deployment my-app -n default

# View logs
kubectl logs -l app.kubernetes.io/name=my-app -n default --tail=100
```

## Rollback

If something goes wrong:

```bash
# List release history
helm history my-app -n default

# Rollback to previous version
helm rollback my-app -n default

# Rollback to specific revision
helm rollback my-app <REVISION_NUMBER> -n default
```

